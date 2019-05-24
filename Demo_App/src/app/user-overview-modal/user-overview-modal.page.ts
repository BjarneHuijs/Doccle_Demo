import { Component } from '@angular/core';
import {ModalController, NavController, NavParams} from '@ionic/angular';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-user-overview-modal',
  templateUrl: './user-overview-modal.page.html',
  styleUrls: ['./user-overview-modal.page.scss'],
})
export class UserOverviewModalPage {
  users: any;

  constructor(private modalController: ModalController, private navParams: NavParams,
              private navCtrl: NavController, private http: HttpClient) {
    this.users = navParams.get('users');
  }

  connectToUser(id) {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };
    const body = {
      connectTo: id,
    };

    this.http.post('http://localhost:8080/users/connect/', body, options).subscribe(data => {
      console.log(data);
    }, error => {
      console.log(error);
    }, () => {
      console.log('POST request successfully sent');
    });
  }

  closeModal() {
    this.modalController.dismiss(this);
  }
}
