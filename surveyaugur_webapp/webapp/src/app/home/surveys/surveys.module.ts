import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button'
import { SurveysRoutingModule } from './surveys-routing.module';
import { SurveysComponent } from './surveys.component';
import { MatTabsModule } from '@angular/material/tabs';
import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';

@NgModule({
  declarations: [SurveysComponent],
  imports: [
    CommonModule,
    SurveysRoutingModule,
    MatTabsModule,
    HttpClientModule,
    MatButtonModule,
    MatTableModule
  ]
})
export class SurveysModule { }
