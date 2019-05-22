import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ModalController} from '@ionic/angular';
import {FeedItemModalPage} from '../feed-item-modal/feed-item-modal.page';

@Component({
  selector: 'app-tab5',
  templateUrl: 'tab5.page.html',
  styleUrls: ['tab5.page.scss']
})
export class Tab5Page {
  items: any;
  item: any;

  constructor(private http: HttpClient, private modalController: ModalController) {
    this.getItems();
  }

  getItems() {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };

    this.http.get('http://localhost:8080/feed/', options).subscribe(data => {
      this.items = data;
      console.log(this.items);
    });
  }

  async openItem(item) {
    this.getItem(item.id, item.title);
    const modal = await this.modalController.create({
      component: FeedItemModalPage,
      componentProps: {
        title: item.title,
        content: item.content
      }
    });
    return await modal.present();
  }

  getItem(id, title) {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };

    this.http.get('http://localhost:8080/feed/' + title, options).subscribe(data => {
      this.item = data;
      console.log(this.item);
    });
  }

  refreshItems() {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };

    this.http.get('http://localhost:8080/refreshFeed', options).subscribe(data => {
      this.items = data;
      console.log(this.items);
    });
  }
}
