package Heaps_And_PriorityQueues.Lec3_Hards;
import java.util.*;
/*Q1 355. Design Twitter
Medium
Topics
Companies
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 

Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
 

Constraints:

1 <= userId, followerId, followeeId <= 500
0 <= tweetId <= 104
All the tweets have unique IDs.
At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
188.3K
Submissions
470.1K
Acceptance Rate
40.1% */
//Not written by me personally, just the soln. I used to learn
public class Twitter {
    private static int timeStamp = 0;

    // User class to represent each user in Twitter
    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // User should follow themself
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            if (id != this.id) {
                followed.remove(id);
            }
        }

        public void post(int id) {
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    // Tweet class to represent each tweet
    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    private Map<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User newUser = new User(userId);
            userMap.put(userId, newUser);
        }
        userMap.get(userId).post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user themselves.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();
        if (!userMap.containsKey(userId)) return newsFeed;

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(followedUsers.size(), (a, b) -> b.time - a.time);

        for (int user : followedUsers) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                tweetHeap.add(tweet);
            }
        }

        int count = 0;
        while (!tweetHeap.isEmpty() && count < 10) {
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id);
            count++;
            if (tweet.next != null) {
                tweetHeap.add(tweet.next);
            }
        }

        return newsFeed;
    }

    /** Follower follows a followee. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }
        if (!userMap.containsKey(followeeId)) {
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}