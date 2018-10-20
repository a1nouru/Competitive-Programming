/*

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

*/

void Segregate(struct LLNode **head)
{
    struct LLNode *end = *head;
    struct LLNode *previous = NULL;
    struct LLNode *current = *head;
    //get the pointer to the last node
    while (end->next != NULL)
    {
        end = end->next;
    }
    struct LLNode *new_end = end;
    //Move all odd nodes before first even to the end
    while(current->data % 2 != 0 && current != end)
    {
        new_end->next = current;
        current = current->next;
        new_end->next->next = NULL;
        new_end = new_end->next;
    }
 
    //Change head to the first even node
    if(current->data%2 == 0)
    {
        //current points to first even
        *head = current;
        while(current!= end)
        {
            //If found even move forward and store previous
            if((current->data)%2 == 0)
            {
                previous = current;
                current = current->next;
            }
            //detach the odd and add it in the end
            //update end
            else
            {
                previous->next = current->next;
                current->next = NULL;
                new_end->next = current;
                new_end = current;
                current = previous->next;
            }
        }
    }
    else previous = current;
    //If till end there is no even then make next of end to null
    if (new_end!=end && (end->data)%2 != 0)
    {
        previous->next = end->next;
        end->next = NULL;
        new_end->next = end;
    }
    return;
}
