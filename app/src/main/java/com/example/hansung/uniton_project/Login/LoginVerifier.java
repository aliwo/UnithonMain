package com.example.hansung.uniton_project.Login;

/**
 * Created by aliwo on 2017-07-29.
 */

public class LoginVerifier
{

    public boolean verify(int option, String text)
    {
        //:TODO: 공백이 없는지 확인합니다. 이름이든 계정이든 패스워드든 공백이 있으면 안됩니다.
        if (spaceCheck(text))
            return false;

        switch (option)
        {
            case 1: //이름
                return true;

            case 2: //계정
                return true;

            case 3: //패스워드
                return true;
        }

        return false;
    }

    private boolean spaceCheck(String spaceCheck)
    {
        for(int i = 0 ; i < spaceCheck.length() ; i++)
        {
            if(spaceCheck.charAt(i) == ' ')
                return true;
        }
        return false;
    }

}
