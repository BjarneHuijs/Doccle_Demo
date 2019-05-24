import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {NavParams} from '@ionic/angular';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.page.html',
  styleUrls: ['./chat.page.scss'],
})
export class ChatPage {
  chats: any;
  chat: any;
  messages: any;

  constructor(public http: HttpClient) {
    this.getChats();
  }

  getChats() {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };

    this.http.get('http://localhost:8080/chat/', options).subscribe(data => {
      this.chats = data;
      console.log(this.chats);
    });
  }

  showChat(id) {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };

    this.http.get('http://localhost:8080/chat/' + id, options).subscribe(data => {
      this.chat = data;
      this.messages = this.chat.messages;
      console.log(this.chat);
    });
  }

}
