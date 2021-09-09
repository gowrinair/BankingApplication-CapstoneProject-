import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ViewcustomerComponent } from './viewcustomer/viewcustomer.component';
import { HttpClientModule } from '@angular/common/http';
import { AddCustomerComponent } from './add-customer/add-customer.component';
// import { AddCustomerComponent } from './add-customer/add-customer.component';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './login/login.component';
// import {NgForm} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { ViewprofileComponent } from './viewprofile/viewprofile.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ServiceComponent } from './service/service.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { TransferComponent } from './transfer/transfer.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { RouterModule } from '@angular/router';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { UpdateComponent } from './update/update.component';
import { BalanceComponent } from './balance/balance.component';







@NgModule({
  declarations: [
    AppComponent,
    ViewcustomerComponent,
     AddCustomerComponent,
     LoginComponent,
     ViewprofileComponent,
     HomeComponent,
     AboutComponent,
     ServiceComponent,
     TransferComponent,
     UpdateComponent,
     BalanceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CarouselModule.forRoot(),
    // ActivatedRoute,
  
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatSidenavModule,
    MatDialogModule,RouterModule
    // RouterModule.forRoot(routes)
   
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
