import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';

import { UserOverviewModalPage } from './user-overview-modal.page';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [UserOverviewModalPage],
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
  ],
  entryComponents: [UserOverviewModalPage]
})
export class UserOverviewModalPageModule {}
