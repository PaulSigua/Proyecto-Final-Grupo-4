import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { NotLoggedComponent } from './not-logged/not-logged.component';
import { AccountInfoComponent } from './account-info/account-info.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    NotLoggedComponent,
    AccountInfoComponent,

  ],
  imports: [
    CommonModule,
    AccountRoutingModule,
    FormsModule
  ]
})
export class AccountModule { }
