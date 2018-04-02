import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import {Observable} from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AuthService {
  backUrl='http://localhost:5000';
  constructor(private router: Router, private http: HttpClient) { }

  isLoggedIn(){
    if(!localStorage.getItem('xhr_token')){
      this.router.navigate(['/registration']);
      return of(false);
    }

    return of(true);
  }

  login(user:any){
    return this.http.post(this.backUrl + 'user/login', {user: user}).subscribe((res:any) => {
      if(res.xrs_token){
        localStorage.setItem('xhr_token', res.xhr_token);
      }
      else {
        this.router.navigate['/registration'];
      }
    }, error => {
      console.log(error);
      this.router.navigate['/registration']
    });
  }

}
