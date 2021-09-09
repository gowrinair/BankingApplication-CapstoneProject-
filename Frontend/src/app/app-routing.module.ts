import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewcustomerComponent } from './viewcustomer/viewcustomer.component';
import { LoginComponent } from './login/login.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ServiceComponent } from './service/service.component';
import { TransferComponent } from './transfer/transfer.component';
import { AuthGuard } from './shared/Authentication/auth.guard';
import { ViewprofileComponent } from './viewprofile/viewprofile.component';
import { UpdateComponent } from './update/update.component';
import { BalanceComponent } from './balance/balance.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"login",component:LoginComponent},
  
  {path:"register",component:AddCustomerComponent},
  {path:"about",component:AboutComponent},
  //  { path:'services/:userName', component: ServiceComponent },
  {path:"services",component:ServiceComponent,canActivate:[AuthGuard]},
  {path:"viewProfile",component:ViewprofileComponent,canActivate:[AuthGuard]},
  {path:"viewcustomer",component:ViewcustomerComponent,canActivate:[AuthGuard]},
  {path:"update",component:UpdateComponent,canActivate:[AuthGuard]},
  {path:"balance",component:BalanceComponent,canActivate:[AuthGuard]},
  {path:"transfer",component:TransferComponent,canActivate:[AuthGuard]},
  {path:"**",component:HomeComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
