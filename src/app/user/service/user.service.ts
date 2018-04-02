import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class UserService {
  constructor(private http: HttpClient, private router: Router) { }

  isLoggedIn(user: User): boolean{
    return localStorage.getItem('xhs_token') != undefined;
  }

  loggin(user: User){
    let options = { login: user.email, password: user.password}
    this.http.post('/login', options)
      .subscribe(
        (json:any)=> {
          localStorage.setItem('xhs_token', json.xhs_token);
          this.router.navigateByUrl('/home', json);
        },
        error => this.router.navigateByUrl('/registration'));
  }

}
