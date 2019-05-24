import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ModalController} from '@ionic/angular';
import {UserOverviewModalPage} from '../user-overview-modal/user-overview-modal.page';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {
  users: any;

  constructor(private http: HttpClient, private modalController: ModalController) {
    this.getUsers();
  }

  async showUserSelect() {
    this.getUsers();
    const modal2 = await this.modalController.create({
      component: UserOverviewModalPage,
      componentProps: {
        users: this.users
      }
    });
    return await modal2.present();
  }

  getUsers() {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };

    this.http.get('http://localhost:8080/users/', options).subscribe(data => {
      this.users = data;
      console.log(this.users);
    });
  }
}
