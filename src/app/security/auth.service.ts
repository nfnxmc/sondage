import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
//import 'rxjs/add/operator/of';

@Injectable()
export class AuthService {

  constructor(private router: Router, private http: HttpClient) { }

  isLoggedIn():Observable<boolean>{
    if(!localStorage.getItem('xhr_token')){
      this.router.navigate(['/registration']);
      return Observable.of(false);
    }

    return Observable.of(true);
  }

  logIn(user:any){
    this.http.post('/login', user)
      .subscribe(
        token => localStorage.setItem('xhr_token', JSON.stringify(token)),
        error => this.router.navigate(['/registration'], user)
      );
  }

}
