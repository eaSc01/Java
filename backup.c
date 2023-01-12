#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
ABOUT CALCULATOR 1.0 PROJECT -:

PROGRAM CREATED BY ISHANT SIKDAR on 11th Jan 2023 For CSI
This Program can perform various tasks such as
Repeated addition, subtractions, multiplications, division,
can also deal with exponent numbers and square roots, etc

Program works best on a console window or Visual Studio 2022 Console Window
or Visual Studio Code Terminal Window.

Program is built on C Language on Visual Studio Code, GNU GCC Compiler.
*/

// Features like History & Trigonometric Calculations are under development

// declaration of upcoming defined functions

double sum_of_numbers(int total_count);
double sub_of_numbers(int total_count);
double prod_of_numbers(int total_count);
double div_of_numbers(int total_count);
void roots_quad();
double trigono_angle(int property, double degree);

//============================================================================================================================================================

// main

int main()
{

    // declaration of variables, there are rare scenarios when these variables are used where they were not meant to use, for memory saving.

    int choice = 0;      // Choice accepts user's choice
    int count = 0;       // Count tracks number of iterations also passed as function argument
    short int error = 0; // Tracks if there's an error or not. (0 and 1)
    double result = 0;   // Result stores the final answer for temporary time also for input in some scenarios

    system("cls");

    do
    {
        system("cls");
        printf("CALCULATOR 1.0\n\n\n");

    jumpx:;
        if (error == 1)
        {
            system("cls");
            printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN\n\n");
            error = 0;
        }
        printf("ENTER CHOICES\nENTER 1 TO ADD NUMBERS\nENTER 2 TO SUBTRACT NUMBERS\nENTER 3 TO MULTIPLY NUMBERS\nENTER 4 TO DIVIDE NUMBERS\nENTER 5 TO CALCULATE EXPONENT NUMBER\nENTER 6 TO FIND SQUARE ROOT OF A NUMBER\nENTER 7 TO FIND ROOTS OF A QUADRATIC EQUATION\nENTER 8 TO FIND TRIGONOMETRIC VALUES\nENTER 9 TO FIND RECIPROCAL OF A NUMBER\nENTER 10 TO FIND REMAINDER IN A DIVISON EXPRESSION\nENTER 0 TO EXIT\n\nYOUR CHOICE: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
        jump1:; // sub program for user choice 1
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER NUMBER OF TIMES YOU WANT TO ADD: ");
            scanf("%d", &count);

            result = sum_of_numbers(count);
            printf("\nSUM OF YOUR NUMBERS: %lf", result);

        jump2:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }

            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump1;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump2;
            }

        case 2:
        jump3:; // sub program for user choice 2
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER NUMBER OF TIMES YOU WANT TO SUBTRACT: ");
            scanf("%d", &count);

            result = sub_of_numbers(count);
            printf("\nFINAL RESULT: %lf", result);

        jump4:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump3;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump4;
            }

        case 3:
        jump5:; // sub program for user choice 3
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER NUMBER OF TIMES YOU WANT TO MULTIPLY: ");
            scanf("%d", &count);

            result = prod_of_numbers(count);
            printf("\nPRODUCT OF YOUR NUMBERS: %lf", result);

        jump6:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump5;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump6;
            }

        case 4:
        jump7:; // sub program for user choice 4
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER NUMBER OF TIMES YOU WANT TO DIVIDE: ");
            scanf("%d", &count);

            result = div_of_numbers(count);
            printf("\nFINAL RESULT: %lf", result);

        jump8:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump7;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump8;
            }

        case 5:
        jump9:; // sub program for user choice 5, calculates exponent number
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER THE BASE NUMBER: ");
            scanf("%lf", &result);
            printf("ENTER THE EXPONENT OF NUMBER: ");
            scanf("%d", &count);

            result = pow(result, count);
            printf("\nVALUE OF YOUR EXPONENT NUMBER: %lf", result);

        jump10:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump9;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump10;
            }

        case 6:
        jump11:; // sub program for user choice 6, finds the square root of a number
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER THE NUMBER TO FIND ITS SQUARE ROOT: ");
            scanf("%lf", &result);

            result = sqrt(result);
            printf("\nSQUARE ROOT OF YOUR NUMBER: %lf", result);

        jump12:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump11;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump12;
            }

        case 7:
        jump13:; // sub program for user choice 6, finds square root of a number
            system("cls");
            roots_quad(); // avoiding passing arguments, to save memory, in this program 4 placeholders were required, by this way the placeholders will be only declared when needed, i.e, whenever program calls roots_quad()

        jump14:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump13;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump14;
            }

        case 8:

        jump19:;
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER 1 TO FIND SINE OF AN ANGLE\nENTER 2 TO FIND COSINE OF AN ANGLE\nENTER 3 TO FIND TANGENT OF AN ANGLE\nENTER 4 TO FIND SECANT OF AN ANGLE\nENTER 5 TO FIND COSECANT OF AN ANGLE\nENTER 6 TO FINT COTANGENT OF AN ANGLE\n\nENTER YOUR CHOICE: ");
            scanf("%d", &choice);
            printf("ENTER ANGLE IN DEGREES: ");
            scanf("%lf", &result);

            result = trigono_angle(choice, result);
            printf("\nVALUE: %lf", result);

        jump20:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }

            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump19;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump20;
            }

        case 9:
        jump15:;
            system("cls");
            printf("CALCULATOR 1.0\n\n\nENTER THE NUMBER TO FIND ITS RECIPROCAL: ");
            scanf("%lf", &result);
            result = 1 / result;
            printf("\nRECIPROCAL OF YOUR NUMBER: %lf", result);
        jump16:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump15;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump16;
            }

        case 10:
        jump17:;
            system("cls");
            printf("CALCULATOR 1.0\n\n\n(WARNING: ONLY USE INTEGRAL NUMBERS)\nENTER THE DIVIDEND: ");
            scanf("%d", &choice);
            printf("ENTER THE DIVISOR: ");
            scanf("%d", &count);
            choice = choice % count; // used only integer variables
            printf("\nREMAINDER OF YOUR NUMBER: %d", choice);

        jump18:;
            if (error == 1)
            {
                system("cls");
                printf("CALCULATOR 1.0\n\n\nINVALID INPUT, TRY AGAIN");
                error = 0;
            }
            printf("\n\nENTER 1 TO TRY AGAIN\nENTER 2 TO STEP BACK TO MAIN MENU\nENTER 3 TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                goto jump17;
            }
            else if (choice == 2)
            {
                break;
            }
            else if (choice == 3)
            {
                goto exit;
            }
            else
            {
                error = 1;
                goto jump18;
            }

        case 0:
        // program to exit complete program
        exit:;
            system("cls");
            printf("CALCULATOR 1.0\n\n\nARE YOU SURE TO QUIT THE PROGRAM?\nENTER 1 FOR NO\nENTER 2 OR ANY ANOTHER NUMBER TO QUIT\nYOUR CHOICE: ");
            scanf("%d", &choice);

            if (choice == 1)
            {
                break;
            }
            else
            {
                exit(0);
            }

        default:
            // for invalid input
            error = 1;
            goto jumpx;
        }

    } while (1);

    return 0;
}

//============================================================================================================================================================

// defined functions

double sum_of_numbers(int total_count)
{ // function for repeated addition

    double sum = 0, input;

    for (int i = 1; i <= total_count; i++)
    {
        printf("ENTER NUMBER %d TO ADD: ", i);
        scanf("%lf", &input);
        sum += input;
    }

    return sum;
}

double sub_of_numbers(int total_count)
{ // function for repeated subtraction

    double sub = 0, input, initial_input;
    printf("ENTER AN INITIAL NUMBER FROM WHICH YOU WANT TO SUBTRACT: ");
    scanf("%lf", &initial_input);
    printf("ENTER NUMBER 1 TO SUBTRACT: ");
    scanf("%lf", &input);
    sub = initial_input - input;

    for (int i = 2; i <= total_count; i++)
    {
        printf("ENTER NUMBER %d TO SUBTRACT: ", i);
        scanf("%lf", &input);
        sub -= input;
    }

    return sub;
}

double prod_of_numbers(int total_count)
{ // function for repeated multiplication

    double prod = 1, input;

    for (int i = 1; i <= total_count; i++)
    {
        printf("ENTER NUMBER %d TO MULTIPLY: ", i);
        scanf("%lf", &input);
        prod *= input;
    }

    return prod;
}

double div_of_numbers(int total_count)
{ // function for repeated divison

    double div = 1, input, initial_input;
    printf("ENTER AN INITIAL NUMBER FROM WHICH YOU WANT TO SUBTRACT: ");
    scanf("%lf", &initial_input);
    printf("ENTER NUMBER 1 TO DIVIDE: ");
    scanf("%lf", &input);
    div = initial_input - input;

    for (int i = 2; i <= total_count; i++)
    {
        printf("ENTER NUMBER %d TO DIVIDE: ", i);
        scanf("%lf", &input);
        div /= input;
    }

    return div;
}

void roots_quad()
{ // Finds roots of a Quadratic Equation
    system("cls");
    float a, b, c, d;
    printf("CALCULATOR 1.0\n\n\nENTER THE COEFFICIENTS OF -:\n");
    printf("ENTER A:");
    scanf("%f", &a);
    printf("ENTER B:");
    scanf("%f", &b);
    printf("ENTER C:");
    scanf("%f", &c);

    d = (b * b) - (4 * a * c);

    if (d > 0)
    {
        printf("\nROOTS ARE ");
        printf("%f AND ", (float)(-b + sqrt(d)) / (2 * a));
        printf("%f", (float)(-b - sqrt(d)) / (2 * a));
    }
    else
    {
        printf("\nROOTS ARE IMAGINARY");
    }
}

double trigono_angle(int property, double degree)
{
    double result, radian;
    radian = degree * (3.14159 / 180);

    if (property == 1)
    {
        result = sin(radian); // sine
    }
    else if (property == 2)
    {
        result = cos(radian); // cosine
    }
    else if (property == 3)
    {
        result = tan(radian); // tangent
    }
    else if (property == 4)
    {
        result = 1 / cos(radian); // secant
    }
    else if (property == 5)
    {
        result = 1 / sin(radian); // cosecant
    }
    else if (property == 6)
    {
        result = 1 / tan(radian); // cotangent
    }
    return result;
}







// EOF=========================================================================================================================================================