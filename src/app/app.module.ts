import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserComponent } from './user/user.component';
import { PollComponent } from './poll/poll.component';
import { ChoiceComponent } from './choice/choice.component';
import { ChoiceService } from './choice/service/choice.service';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ChartComponent } from './poll/chart/chart.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationComponent } from './registration/registration.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthService } from './security/auth.service';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    ChoiceComponent,
    AppComponent,
    NavbarComponent,
    UserComponent,
    PollComponent,
    ChartComponent,
    RegistrationComponent,
  ],
  exports: [ChoiceComponent],
  imports: [
    BrowserModule,
    NgxChartsModule,
    BrowserAnimationsModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [ChoiceService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
