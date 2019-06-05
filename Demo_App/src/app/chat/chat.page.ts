import { Component, OnInit, OnDestroy } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {interval} from 'rxjs';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.page.html',
  styleUrls: ['./chat.page.scss'],
})
export class ChatPage implements OnInit, OnDestroy {
  chats: any;
  chat: any;
  messages: any;
  msgToSend: string;
  shown: boolean;
  clickedChat: string;
  private timer;

  constructor(public http: HttpClient) {
    this.getChats();
    this.shown = false;
  }

  ngOnInit() {
    this.timer = interval(5000);
    this.timer.subscribe((t) => this.getChats());
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
    this.clickedChat = id;
    if (this.shown === false) {
      const options = {
        headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
      };

      this.http.get('http://localhost:8080/chat/' + id, options).subscribe(data => {
        this.chat = data;
        this.messages = this.chat.messages;
        console.log(this.chat);
      });
      this.shown = true;
    } else {
      this.chat = null;
      this.messages = null;
      this.shown = false;
      this.clickedChat = '';
    }
  }

  sendMessage(chat) {
    const options = {
      headers: new HttpHeaders({'Content-type': 'application/json', Accept: 'application/json, */*'}),
    };
    const body = {
      from: 'Bjarne@users.be',
      message: this.msgToSend
    };

    this.http.post('http://localhost:8080/chat/' + chat.id, body, options).subscribe(data => {
      console.log(data);
      this.chat = data;
      this.messages = this.chat.messages;
    }, error => {
      console.log(error);
    }, () => {
      console.log('POST request successfully sent');
      this.msgToSend = '';
    });
    this.getChats();
  }

  ngOnDestroy() {
    this.timer.unsubscribe();
  }
}
