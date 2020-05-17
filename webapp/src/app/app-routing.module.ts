import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AccountingComponent } from './accounting/accounting.component';
import { ManagementComponent } from './management/management.component';


const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent},
  {path: 'blueprint', loadChildren: () => import('./modules/blueprint/blueprint.module').then(m => m.BlueprintModule)},
  {path: 'profile', loadChildren: () => import('./modules/profile/profile.module').then(m => m.ProfileModule)},
  {path: 'accounting', component: AccountingComponent},
  {path: 'management', component: ManagementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
