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

@NgModule({
  declarations: [
    ChoiceComponent,
    AppComponent,
    NavbarComponent,
    UserComponent,
    PollComponent,
    ChartComponent,
  ],
  exports: [ChoiceComponent],
  imports: [
    BrowserModule,
    NgxChartsModule,
    BrowserAnimationsModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [ChoiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
