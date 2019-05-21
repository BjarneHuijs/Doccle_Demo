import { NgModule } from '@angular/core';
import { SwipeTabDirective } from './swipe_tab.directive';

@NgModule({
    declarations: [
        SwipeTabDirective
    ],
    exports: [
        SwipeTabDirective
    ]
})
export class DirectivesModule { }
