export class Users {
    id: string;
    username: string;
    lastName: string;
    firstName: string;
    email: string;
    enabled: boolean;
    attributes: Attributes;
}
export class Attributes {
    birthday : string;
    nationality :string;
    gender : string;
    telephone : string;
    zip_code : string;
    imgUrl : string="";
}
