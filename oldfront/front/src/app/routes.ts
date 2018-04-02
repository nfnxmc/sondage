import { Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PollComponent } from './poll/poll.component';
import { AuthGuard } from './security/authguard';

const routes = [
    {
        path:'mypolls/:id', 
        component: AppComponent,
        canActivate: [AuthGuard]
    },
    {
        path: 'addpoll',
        component: PollComponent,
        canActivate: [AuthGuard]
    },
    {
        path: 'deletepoll',
        component: PollComponent,
        canActivate: [AuthGuard]
    }
]