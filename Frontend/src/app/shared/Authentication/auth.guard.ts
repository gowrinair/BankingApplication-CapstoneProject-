import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) :boolean {
    // return false;
    if(!!sessionStorage.getItem('user')){
      return true;

    }
    else{
      alert("Please Login!!");
      return false;
     
    }
  }
  
}
