import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { activesurveyRoutingModule } from './activesurvey-routing.module';
import {MatPaginatorModule} from '@angular/material/paginator';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    activesurveyRoutingModule,
    MatPaginatorModule
  ]
})
export class ActivesurveyModule { }
