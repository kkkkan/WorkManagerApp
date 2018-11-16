# WorkManagerApp

On API 15 devices, when using WorkManager , Notification is deleted automatically.</br>
This app reproduce the bug.

## Procedure
1. push "Push Notification" button, and then notification come soon.
1. push "Start Work Manager" button. ( Soon OneTimeWorkRequest that only return Result.SUCCESS work is enqueued. )
1. wait 10~20 seconds.
1. Notification is deleted automatically.

## Environment
- device
  - Galaxy Nexus, API 15 ( emulator )
  - SHARP SH-06D, API 15 ( actual device )
