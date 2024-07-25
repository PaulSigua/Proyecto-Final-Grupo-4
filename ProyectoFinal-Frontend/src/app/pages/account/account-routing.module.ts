import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountInfoComponent } from './account-info/account-info.component';
import { NotLoggedComponent } from './not-logged/not-logged.component';

const routes: Routes = [
  {path: 'info', component: AccountInfoComponent},
  {path: 'not-logged', component: NotLoggedComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule { }
