import { Component, OnInit, OnDestroy } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ModalController} from '@ionic/angular';
import {UserOverviewModalPage} from '../user-overview-modal/user-overview-modal.page';
import {interval} from 'rxjs';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page implements OnInit, OnDestroy {
  users: any;
  conUsers: any;
  private timer;

  constructor(private http: HttpClient, private modalController: ModalController) {
    this.getUsers();
    this.getConUsers();
  }

  ngOnInit() {
    this.timer = interval(5000);
    this.timer.subscribe((t) => this.getUsers());
    this.timer.subscribe((t) => this.getConUsers());
  }

  async showUserSelect() {
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

  getConUsers() {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };

    this.http.get('http://localhost:8080/connectedUsers/', options).subscribe(data => {
      this.conUsers = data;
      console.log(this.conUsers);
    });
  }

  ngOnDestroy() {
    this.timer.unsubscribe();
  }
}
