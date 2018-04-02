import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable()
export class AuthService {

  constructor(private router: Router) { }

  isLoggedIn(){
    if(!localStorage.getItem('xhr_token')){
      this.router.navigate(['/registration']);
      return false;
    }

    return true;
  }

}
