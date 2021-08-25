import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ActivesurveyComponent } from './activesurvey.component'; 

const routes: Routes = [{ path: '', component: ActivesurveyComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class activesurveyRoutingModule { }
