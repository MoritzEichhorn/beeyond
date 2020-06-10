import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TemplateRoutingModule } from './template-routing.module';
import { TemplateComponent } from './pages/template/template.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { SharedModule } from '../../shared/shared.module';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { TemplateCreateComponent } from './pages/template-create/template-create.component';

@NgModule({
  declarations: [TemplateComponent, TemplateCreateComponent],
  imports: [
    CommonModule,
    TemplateRoutingModule,
    MatCardModule,
    MatButtonModule,
    SharedModule,
    MatInputModule,
    MatIconModule,
  ]
})
export class TemplateModule { }
