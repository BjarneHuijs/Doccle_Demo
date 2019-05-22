import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';

import { FeedItemModalPage } from './feed-item-modal.page';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [FeedItemModalPage],
  imports: [
    CommonModule,
    IonicModule,
    FormsModule,
  ],
  entryComponents: [FeedItemModalPage]
})
export class FeedItemModalModule {}
