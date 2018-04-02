import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../security/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean;
  email = new FormControl('', [Validators.required, Validators.minLength(3)]);
  password = new FormControl('', [Validators.required, Validators.minLength(5)]);
  loginForm: FormGroup;

  constructor(private auth: AuthService) { }

  ngOnInit() {
    this.loginForm = this.buildForm();
  }

  buildForm(){
    return new FormGroup({
      email: this.email, 
      password: this.password
    });
  }

  signIn(){
    this.auth.isLoggedIn().subscribe(isloggedIn => this.isLoggedIn = isloggedIn);
  }

}
