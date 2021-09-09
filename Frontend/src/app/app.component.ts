import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'capstoneProject';
  constructor(private router:Router) {    
  }
  logout():void{
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('pass');
    this.router.navigateByUrl('/login');
  }
}
