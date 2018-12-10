import { Injectable } from '@angular/core';
import {
  Http, ConnectionBackend, RequestOptions, Request, Response, RequestOptionsArgs, RequestMethod, ResponseOptions
} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/environment';
import { catchError } from 'rxjs/operators';
import { Subscriber } from 'rxjs/Subscriber';
import { _throw } from 'rxjs/observable/throw';
import { extend } from 'lodash';
import { HttpCacheService } from './http-cache.service';
import { AuthenticationService } from '../authentication/authentication.service';
import { AuthcredentialstoreService } from '../authentication/authcredentialstore.service';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class HttpService extends Http {

  constructor(backend: ConnectionBackend,
    private defaultOptions: RequestOptions,
    private httpCacheService: HttpCacheService,
    private authStore: AuthcredentialstoreService) {
    // Customize default options here if needed
    super(backend, defaultOptions);
  }

  request(request: string | Request, options?: RequestOptionsArgs): Observable<Response> {

    const requestOptions = options || {};

    let url: string;

    if (typeof request === 'string') {
      url = request;
      request = environment.serverUrl + url;
    } else {
      url = request.url;
      request.url = environment.serverUrl + url;
    }

    if (this.authStore.isAuthenticated()) {
      this.defaultOptions.headers.set('Authorization', 'Bearer ' + this.authStore.credentials.token);
    }

    return this.httpRequest(request, requestOptions);
    // return new Observable((subscriber: Subscriber<Response>) => {
    //   this.httpRequest(request, options).subscribe(
    //     (response: Response) => {
    //       subscriber.next(response);
    //     },
    //     (error) => subscriber.error(error),
    //     () => subscriber.complete()
    //   );
    // });
  }

  get(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Get }));
  }

  post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, {
      body: body,
      method: RequestMethod.Post
    }));
  }

  put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, {
      body: body,
      method: RequestMethod.Put
    }));
  }

  delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Delete }));
  }

  patch(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, {
      body: body,
      method: RequestMethod.Patch
    }));
  }

  head(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Head }));
  }

  options(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.request(url, extend({}, options, { method: RequestMethod.Options }));
  }

  // Customize the default behavior for all http requests here if needed
  private httpRequest(request: string | Request, options: RequestOptionsArgs): Observable<Response> {
    let req = super.request(request, options);
    // if (!options.skipErrorHandler) {
    req = req.pipe(catchError((error: any) => this.errorHandler(error)));
    // }
    return req;
  }

  // Customize the default error handler here if needed
  private errorHandler(response: Response): Observable<Response> {

    if (environment.production) {
      // Avoid unchaught exceptions on production
      // console.log('Request error', response.json().data);

      return _throw(response);
    }

    // console.log("Test Error Handler")
    // console.log(JSON.parse(response.text()));

    throw response;
  }
}
