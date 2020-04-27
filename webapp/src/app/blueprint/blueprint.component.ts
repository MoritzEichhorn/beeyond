import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSelectionList } from '@angular/material/list';
import { HttpApiService } from '../service/http-api.service';

@Component({
  selector: 'app-blueprint',
  templateUrl: './blueprint.component.html',
  styleUrls: ['./blueprint.component.css']
})
export class BlueprintComponent implements OnInit {

  @ViewChild('blueprints') blueprints: MatSelectionList;
  templates: string[] = [];

  constructor(private httpApiService: HttpApiService) { }

  ngOnInit(): void {
    this.httpApiService.getAllTemplates().subscribe(value => this.templates = value);
  }

}
