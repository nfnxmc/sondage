import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { UserService } from '../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  fname: FormControl;
  lname: FormControl;
  email: FormControl;
  password: FormControl;
  name: FormGroup;

  registrationForm: FormGroup;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.buildForm();
    console.log(this.registrationForm);
  }

  buildForm(){
    let pattern = "([a-zA-Z0-9]){3}*@([a-zA-Z0-9]){3}*\.([a-zA-Z0-9]){3}*)";
    this.fname = new FormControl('', Validators.minLength(3));
    this.lname = new FormControl('', Validators.minLength(3));
    this.email = new FormControl('', Validators.minLength(3));
    this.password = new FormControl('', Validators.minLength(3))
    
    this.registrationForm = new FormGroup({
      name: new FormGroup({
        fname: this.fname,
        lname:  this.lname
      }),
      email: this.email,
      password: this.password
    })
  }

  register(user:any) {
    console.log(user);
    this.userService.register(user);
  }

}
