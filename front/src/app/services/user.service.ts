import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class UserService {

  backend = "http://localhost:5000";
 
  constructor(private http: HttpClient, private router: Router) { }

  register(user: any){
    this.http.post(this.backend + 'newuser', {user: user});
  }
}
