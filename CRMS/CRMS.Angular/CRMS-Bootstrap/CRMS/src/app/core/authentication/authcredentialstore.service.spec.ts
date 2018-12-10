import { TestBed, inject } from '@angular/core/testing';

import { AuthcredentialstoreService } from './authcredentialstore.service';

describe('AuthcredentialstoreService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthcredentialstoreService]
    });
  });

  it('should be created', inject([AuthcredentialstoreService], (service: AuthcredentialstoreService) => {
    expect(service).toBeTruthy();
  }));
});
