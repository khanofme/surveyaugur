import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButton } from '@angular/material/button';
import {MatPaginator} from '@angular/material/paginator';

export interface Surveys {
  name: string;
  position: number;
  type: string;
  action: string;
}

const ELEMENT_DATA: Surveys[] = [
  {position: 1, name: 'survey1', type: 'Business', action:''},
  {position: 2, name: 'survey2', type: 'type', action:'' },
  {position: 3, name: 'survey3', type: 'type', action:''},
  {position: 4, name: 'survey4', type: 'type', action:''},
  {position: 5, name: 'survey5', type: 'type', action:''},
  {position: 6, name: 'survey6', type: 'type', action:'' },
  {position: 7, name: 'survey7', type: 'type', action:'' },
  {position: 8, name: 'survey8', type: 'type', action:'' },
  {position: 9, name: 'survey9', type: 'type', action:'' },
  {position: 10, name: 'survey10', type: 'type', action:'' },
];

@Component({
  selector: 'app-activesurvey',
  templateUrl: './activesurvey.component.html',
  styleUrls: ['./activesurvey.component.css']
})
export class ActivesurveyComponent implements OnInit {

  constructor() { }
   displayedColumns: string[] = ['position', 'name', 'type', 'action' ];
    dataSource = ELEMENT_DATA;

    // @ViewChild(MatPaginator) paginator: MatPaginator;


  ngOnInit(): void {
  //this.dataSource.paginator = this.paginator;
  }

}
