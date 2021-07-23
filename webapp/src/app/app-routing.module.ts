import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardGuard } from './auth-guard.guard';
import { HomeComponent } from './components/home/home.component';
import { HotspotsComponent } from './components/hotspots/hotspots.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes= [
  {path:'home', component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path: '',redirectTo:'login',pathMatch:'full'},
  {path: 'hotspot',component:HotspotsComponent, canActivate:[AuthGuardGuard]},
  {path: '',redirectTo:'home',pathMatch:'full'}
  ];



@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
