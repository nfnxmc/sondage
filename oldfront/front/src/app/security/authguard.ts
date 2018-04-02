import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import { Observable } from "rxjs/Observable";
import { AuthService } from "./auth.service";


export class AuthGuard implements CanActivate {
    constructor(private auth: AuthService){}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
        return this.auth.isLoggedIn();
    }
}