import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss'],

})
export class UploadComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {

  }
  public autoCompleteTags = ['Angular', 'React', 'VueJs', 'Meteor', 'Ember.js', 'Aurelia', 'Backbone.js'];
  public selectedValues = ['Angular'];

  change($event) {
    console.log($event)
  }

}
