import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Tab5Page } from './tab5.page';
import {FeedItemModalModule} from '../feed-item-modal/feed-item-modal.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    FeedItemModalModule,
    RouterModule.forChild([{ path: '', component: Tab5Page }])
  ],
  declarations: [Tab5Page]
})
export class Tab5PageModule {}
