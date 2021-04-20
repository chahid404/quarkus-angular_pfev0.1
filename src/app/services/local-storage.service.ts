import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() { }

  saveItem(key, value) {
    return localStorage.setItem(key, value);
  }
  getItem(key) {
    return localStorage.getItem(key);
  }
  getCurrentUser() {
    return localStorage.getItem("userId");
  }
}
