import { BrowserModule} from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthService } from './security/auth.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { routes } from './routes';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './services/user.service';
import { PollComponent } from './poll/poll.component';
import { ChoiceComponent } from './choice/choice.component';
import { PollManagementComponent } from './poll-management/poll-management.component';
import { ChoiceService } from './choice/choice.service';
import { ProgressBarModule } from 'ngx-progress-bar';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RegistrationComponent,
    PollComponent,
    ChoiceComponent,
    PollManagementComponent
  ],
  imports: [
    ProgressBarModule,
    HttpClientModule,
    BrowserModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes,  {useHash:true})
  ],
  providers: [AuthService, UserService, ChoiceService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
