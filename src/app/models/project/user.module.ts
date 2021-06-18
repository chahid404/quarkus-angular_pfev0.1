export class Users {
    id: string;
    username: string;
    lastName: string;
    firstName: string;
    email: string;
    enabled: boolean;
    attributes: Attributes;
}
class Attributes {
    birthday: string;
    nationality: string;
    gender: string;
    telephone: string;
    zip_code: string;
    imgUrl: string = "";
}
export class UsersForUpdate {
    id: string;
    username: string;
    lastName: string;
    firstName: string;
    email: string;
    enabled: boolean;
    attributes: AttributesforUpdate;
}
class AttributesforUpdate {
    birthday: string[] = [];
    nationality: string[] = [];
    gender: string[] = [];
    telephone: string[] = [];
    zip_code: string[] = [];
}
