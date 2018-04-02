import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { PollManagementComponent } from './poll-management/poll-management.component';

export const routes: Routes = [
    {
        path:'',
        component: PollManagementComponent
    },
    {
        path:'registration',
        component: RegistrationComponent
    }
];