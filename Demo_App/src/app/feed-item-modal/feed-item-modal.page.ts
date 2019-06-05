import { Component } from '@angular/core';
import {ModalController, NavController, NavParams} from '@ionic/angular';

@Component({
  selector: 'app-feed-item-modal',
  templateUrl: './feed-item-modal.page.html',
  styleUrls: ['./feed-item-modal.page.scss'],
})
export class FeedItemModalPage {

  title: string;
  content: string;
  link: string;

  constructor(private modalController: ModalController, private navParams: NavParams, private navCtrl: NavController) {
    this.title = this.navParams.get('title');
    this.content = this.navParams.get('content');
    this.link = this.navParams.get('link');
  }

  async ionModalWillPresent() {
    this.title = this.navParams.get('title');
    this.content = this.navParams.get('content');
    this.link = this.navParams.get('link');
  }

  closeModal() {

    this.modalController.dismiss(this);
  }
}
