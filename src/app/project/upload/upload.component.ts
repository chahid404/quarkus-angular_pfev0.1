import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css'],

})
export class UploadComponent implements OnInit {
  SERVER_URL = "http://localhost:8080/documents/uploadfile";
  uploadForm: FormGroup;
  public fileName: string;
  uploadedFiles: any[] = [];
  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.uploadForm = this.formBuilder.group({
      profile: ['']
    });
  }

  display: boolean = false;

  showDialog() {
    this.display = true;
  }

  onFileSelect(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.uploadForm.get('profile').setValue(file);
      this.fileName = event.target.files[0].name;
      console.log(event.target.files[0].name);
    }
  }

  onSubmit() {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('profile').value);
    formData.append('fileName', this.fileName);
    this.httpClient.post<any>(this.SERVER_URL, formData).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  }

  onUpload(event) {
    console.log(event.files[0].name);
    const formData = new FormData();
    formData.append('file', event.files[0]);
    formData.append('fileName', event.files[0].name);
    this.httpClient.post<any>(this.SERVER_URL, formData).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  }

}
