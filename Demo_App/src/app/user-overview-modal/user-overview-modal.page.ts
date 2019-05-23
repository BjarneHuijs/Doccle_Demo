import { Component } from '@angular/core';
import {ModalController, NavController, NavParams} from '@ionic/angular';

@Component({
  selector: 'app-user-overview-modal',
  templateUrl: './user-overview-modal.page.html',
  styleUrls: ['./user-overview-modal.page.scss'],
})
export class UserOverviewModalPage {
  users: any;

  constructor(private modalController: ModalController, private navParams: NavParams, private navCtrl: NavController) {
    this.users = navParams.get('users');
  }

  closeModal() {
    this.modalController.dismiss(this);
  }
}
