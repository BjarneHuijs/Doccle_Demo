import {Component, ViewChild} from '@angular/core';
import {SwipeTabDirective} from '../directives/swipe_tab.directive';
import {IonTabs} from '@ionic/angular';

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss']
})

export class TabsPage {
  @ViewChild(SwipeTabDirective) swipeTabDirective: SwipeTabDirective;
  @ViewChild('myTabs') tabRef: IonTabs;
  constructor() {}

  ionTabsDidChange($event) {
    console.log('[TabsPage] ionTabsDidChange, $event: ', $event);
    this.swipeTabDirective.onTabInitialized($event.tab);
  }

  onTabChange($event) {
    console.log('[TabsPage] OnTabChange, $event', $event);
    this.tabRef.select($event);
  }
}
