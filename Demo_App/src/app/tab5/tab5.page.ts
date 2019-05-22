import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-tab5',
  templateUrl: 'tab5.page.html',
  styleUrls: ['tab5.page.scss']
})
export class Tab5Page {
  items: any;

  constructor(public http: HttpClient) {
  }

  async ionViewWillLoad() {
    /*this.getItems();
    for (const i of this.items) {
      console.log('works');
    }*/
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad NewsFeed');
  }

  getItems() {
    /*const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', 'Accept': 'application/json, * /*'}),
    };

    this.http.get('http://localhost:8080/feed/', options).subscribe(data => {
      this.items = data;
    });*/
  }
}
