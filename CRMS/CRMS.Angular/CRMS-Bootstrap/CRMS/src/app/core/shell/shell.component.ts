import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http/http.service';
import { Http } from '@angular/http';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss']
})
export class ShellComponent implements OnInit {
  constructor(private http: Http) {

  }

  ngOnInit() { }

}
